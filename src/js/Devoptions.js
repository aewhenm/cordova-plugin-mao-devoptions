function Devoptions() {}
  
Devoptions.prototype.pluginName = "Devoptions";

Devoptions.prototype.pInvoke = function(method, data, success, error) {
  cordova.exec(success, error, this.pluginName, method, data);
};
  
Devoptions.prototype.areEnabled = function(success, error) {
  this.pInvoke("areEnabled", null, success, error);
};

Devoptions.install = function() {
  if(!window.plugins) {
    window.plugins = {};
  }
  
  window.plugins.devoptions = new Devoptions();
  return window.plugins.devoptions;
};

cordova.addConstructor(Devoptions.install);
