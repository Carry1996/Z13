function checkuname() {
    var check = false;
    var uname = document.getElementById("uname").value;
    if (uname.length > 15 || uname.length < 1) {
        document.getElementById("checkinput").innerHTML = "请输入2-15位姓名";
        check = false;
    } else {
        document.getElementById("checkinput").innerHTML = "&nbsp;";
        check = true;
    }
    return check;
}

function checkuno() {
    var check = false;
    var uno = document.getElementById("uno").value;
    var reg = new RegExp("^[0-9]*$");
    if (uno.length != 9 || !reg.test(uno)) {
        document.getElementById("checkinput").innerHTML = "请输入9位数字学号";
        check = false;
    } else {
        document.getElementById("checkinput").innerHTML = "&nbsp;";
        check = true;
    }
    return check;
}

function checkpassword1() {
    var check = false;
    var password1 = document.getElementById("password1").value;
    if (password1.length < 8 || password1.length > 16) {
        document.getElementById("checkinput").innerHTML = "请输入8-16位密码";
        check = false;
    } else {
        document.getElementById("checkinput").innerHTML = "&nbsp;";
        check = true;
    }
    return check;
}

function checkpassword2() {
    var check = false;
    var password1 = document.getElementById("password1").value;
    var password2 = document.getElementById("password2").value;

    if (password2 != password1) {
        document.getElementById("checkinput").innerHTML = "两次输入密码不一致";
        check = false;
    } else {
        document.getElementById("checkinput").innerHTML = "&nbsp;";
        check = true;
    }
    return check;
}

function checkemail() {
    var check = false;
    var email = document.getElementById("email").value;
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");
    if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length) {
        document.getElementById("checkinput").innerHTML = "请输入正确格式的邮箱";
        check = false;
    } else {
        document.getElementById("checkinput").innerHTML = "&nbsp;";
        check = true;
    }
    return check;
}
