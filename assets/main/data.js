APPStore = function() {

};

APPStore.APPSTORE_DOMAIN = 'http://10.0.2.2:8080/appstore';
APPStore.APPSTORE_LIST_URL = APPStore.APPSTORE_DOMAIN + '/webapp/list.json';

APPStore.prototype.load = function(callback) {
    $.ajax({
        url: APPStore.APPSTORE_LIST_URL,
        cache: false,
        dataType: 'json',
        success: function(data) {
            if (data.apps) {
                APPStore.cachedApps = {};
                for (var i = 0; i < data.apps.length; i++) {
                    var app = data.apps[i];
                    var id = 'app' + app.id;
                    APPStore.cachedApps[id] = app;
                }
                callback(data.apps);
            }
        }
    });

};