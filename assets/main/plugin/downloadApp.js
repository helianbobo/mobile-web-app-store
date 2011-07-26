var DownloadApp = function() {

};


DownloadApp.prototype.download = function(params, success, fail) {
    return PhoneGap.exec(
        function(args) {
            success(args);
        },
        function(args) {
            fail(args);
        },
        'DownloadApp',
        'download',
        [params]);
};

PhoneGap.addConstructor(function() {
	PhoneGap.addPlugin('downloadapp', new DownloadApp());
	PluginManager.addService("DownloadApp","com.hp.webstore.DownloadAppPlugin");
});