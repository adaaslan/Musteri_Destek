$(function () {
    var url = window.location.pathname, urlRegExp = new RegExp(url.replace(/\/$/, '') + "$");
    $('.menuinf a').each(function () {
        if (urlRegExp.test(this.href.replace(/\/$/, ''))) {
            $(this).addClass('active');
        } else {
            $(this).removeClass('active');

        }
    });
});

