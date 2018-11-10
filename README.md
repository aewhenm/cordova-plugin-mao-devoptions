# cordova-plugin-mao-devoptions
Cordova plugin for Android platform to work with developer options

```xml
<plugin name="cordova-plugin-mao-devoptions source=npm />
```

### areEnabled()
Checks if developer options are enabled.

```js
	window.plugins.devoptions.areEnabled(successCallback, errorCallback);
```
##### Parameters  
  
- {Function} successCallback -  The callback which will be called when operation is successful.  
The function is passed a single integer parameter which is 1 if developer options are enabled.  

- {Function} errorCallback -  The callback which will be called when operation encounters an error.  
The function is passed a single string parameter containing the error message.  
  
  
##### Example usage  
  
```js
window.plugins.devoptions.areEnabled(
	function(enabled){ 
		console.log("Developer options are " + (enabled ? "enabled" : "not enabled")); 
	}, 
	function(error){ 
		console.error("The following error occurred: " + error); 
	}
);
```
