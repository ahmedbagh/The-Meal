<h1 align="center">The Meal</h1>

<p align="center">  
The Meal is a simple demo application based on modern Android tech-stacks and MVVM architecture.
</p>

<img src="/preview/preview.gif" align="right" width="32%"/>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous.
- Jetpack
    - Lifecycle - dispose of observing data when lifecycle state changes.
    - ViewModel - UI related data holder, lifecycle aware.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - [Bindables](https://github.com/skydoves/bindables) - Android DataBinding kit for notifying data changes to UI layers.
    - Repository pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs.
- [GSON](https://github.com/google/gson) - A modern JSON library for Kotlin and Java.
- [Glide](https://github.com/bumptech/glide) - loading images.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components for CardView.

## Architecture
The Meal is based on the MVVM architecture and the Repository pattern.

![architecture](https://user-images.githubusercontent.com/24237865/77502018-f7d36000-6e9c-11ea-92b0-1097240c8689.png)

## Open API
The Meal is using the [TheMealDB](https://www.themealdb.com/about.php) API for constructing RESTful API.
TheMealDB API was built in 2016 to provide a free data source api for recipes online


