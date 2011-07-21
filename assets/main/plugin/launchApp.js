var LaunchApp = function() {

};


LaunchApp.prototype.launch = function(params, success, fail) {
    return PhoneGap.exec(
        function(args) {
            success(args);
        },
        function(args) {
            fail(args);
        },
        'LaunchApp',
        'launch',
        [params]);
};

PhoneGap.addConstructor(function() {
	PhoneGap.addPlugin('launchapp', new LaunchApp());
	PluginManager.addService("LaunchApp","com.hp.webstore.LaunchAppPlugin");
});