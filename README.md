# CustomViewKit

[![](https://jitpack.io/v/GerONSo/CustomViewKit.svg)](https://jitpack.io/#GerONSo/CustomViewKit)

Here you can find some useful Android widgets that I use in my daily life
## Installation
To use these widgets:
- add this to your ```settings.gradle``` (recommended)
```
dependencyResolutionManagement {
    ...
    maven { url 'https://jitpack.io' } 
}
```
- or add this to your ```build.gradle``` on project level
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Than you can add dependency simply by adding to your ```build.gradle``` on app level
```
implementation 'com.github.GerONSo:CustomViewKit:version'
```

## Examples

All examples you can see in ```app``` directory

## Widgets

### LoadingButton

XML
```
<com.geronso.customviewkit.LoadingButton
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/loadingButton"/>
```
Working with states
```
    loadingButton.render {
        // Copy previous state
        this.copy(
            // Set of updated values
            // All values that you skip will be saved from previous state
            isLoading = false,
            text = "Button",
            background = R.drawable.button_login,
            textColor = R.color.colorOnPrimary,
            progressBarColor = R.color.colorOnPrimary
        )
    }
```


