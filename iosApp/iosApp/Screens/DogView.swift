//
//  DogView.swift
//  iosApp
//
//  Created by Kalpen on 27/03/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension DogView {
    @MainActor
    class DogViewModelWrapper: ObservableObject {
        let dogViewModel: DogViewModel
        init() {
            dogViewModel = DogInjector().dogViewModel
            dogState = dogViewModel.dogState.value
        }
        
        @Published var dogState: DogState
        
        func startObsering(){
            Task {
                for await dogG in dogViewModel.dogState {
                    self.dogState = dogG
                }
            }
        }
    }
}

struct DogView: View {
    @ObservedObject private(set) var viewModel: DogViewModelWrapper
    var body: some View {
        VStack {
            AppBar()
            
            if(viewModel.dogState.loading){
                Loader()
            }
            
            if let error = viewModel.dogState.error{
                ErrorMessage(message:error)
            }
            
            if(!viewModel.dogState.dog.message.isEmpty){
                DogItemView(dog: viewModel.dogState.dog)
            }
        }.onAppear{
            self.viewModel.startObsering()
        }
    }
}

struct AppBar: View {
    var body: some View {
        Text("Dog App")
            .font(.headline)
            .fontWeight(.bold)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String
    var body: some View {
        Text(message)
            .font(.title)
    }
}

struct DogItemView: View {
    var dog: Dog
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            AsyncImage(url: URL(string: dog.message)) { phase in
                if phase.image != nil {
                    phase.image!.resizable()
                        .aspectRatio(contentMode: .fit)
                } else if (phase.error != nil){
                    Text("Image load Error")
                } else {
                    ProgressView()
                }
            }
        }
    }
}
