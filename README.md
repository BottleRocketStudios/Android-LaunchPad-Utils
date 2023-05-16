#LaunchPad Quick Start for Android

The LaunchPad Utils project is intended to be an aid for helping you bring your Android projects to market quickly without the need to reinvent the wheel.  It is open source and free to use.

## LaunchPad Utils
This library provides a collection of utilities for logging, Coroutines, Shared Preferences, etc.

## Contributing
This project is open source and we welcome updates from all devs.  Look to [`CONTRIBUTING.md`](./CONTRIBUTING.md) for information on how to help out.

## What's in this library

### Convenience Functions


## Usage
1. You'll need to add a dependency on jitpack to your project build.gradle.kts file. Make sure it is below primary maven repositories such as google() or mavenCentral() as it should have lower precedence in Gradle's dependency resolution process:

    ```kotlin
    allprojects {
	    repositories {
		    ... // likely already have google() and mavenCentral() above
		    maven(url = "https://jitpack.io")
	    }
    }
    ```
2. You'll need to add the following line to your module's build.gradle.kts:

    ```kotlin
    dependencies {
	    ...
	    implementation("com.github.BottleRocketStudios:Android-LaunchPad-Utils:0.0.4")
	    implementation("com.github.BottleRocketStudios:Android-LaunchPad-Utils-Domain:0.0.4")
    }
    ```