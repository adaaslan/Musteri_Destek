

function blinker() {
    $('.blinker').fadeOut(500);
    $('.blinker').fadeIn(500);
}
setInterval(blinker, 1200);

$(function () {
    var url = window.location.pathname, urlRegExp = new RegExp(url.replace(
            /\/$/, '')
            + "$");
    $('.nav li a').each(function () {
        if (urlRegExp.test(this.href.replace(/\/$/, ''))) {
            $(this).parent().addClass('active');
        }
    });

});
