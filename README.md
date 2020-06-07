İsim Soyisim: Rabia Aslan 
Okul numarası: 50150076035
Grup: kişi sayısı 1

NeatBeans - 11.3
MariaDb - Heidi sql 10.2.0.5599 (64 bit) (root /pass: 123)
Glassfish - 5.1.0



Müşteri Destek Platformu

*** Admin giriş bilgileri 
kullanıcı adı: raslan şifre: 1234 
kullanıcı adı: hdagd şifre: 1234 

Proje Özet
örn. Turkcell müşteri hizmetleri; kullanıcı problemlerini mail yoluyla değil de ticket açarak çalışanlar bu sistem üzerinden takip edilebilecek.
Bu şekilde hem müşteri çalışmanın ne aşamada olduğunu, ne zaman biteceğini vs takip edebilecek hem de çalışanlar destek takip edecek
Müşteriler kayıt ol ekranından kayıt olup hangi üründe sorun yaşadığını detaylı bir şekilde dosya yükleyerek vs talep ekleyebilecek.
Alınan hizmetler; tv+/lifebox/dergilik/bip şeklinde listelenir, ilgili konu başlığı girilerek sorununu kaydedip ilgili kişiye yönlendirecek. 

CRUD işlemlerinin hepsi yapıldı

many to many ve one to many ilişkisi: yapıldı
***birçok müşteri birden fazla destek girebilir, bir admin(çalışan) birden çok ürüne destek verebilir. 
(1-n : çalışan talep & n-n :müşteri-destek)

Minimum 1 adet Filter kullanılması: yapıldı (talepler - hizmet)

Xhtml Validator’lerini yazılması: yapıldı
Java Bean Validator’lerini yazılması: yapıldı
***validatörler; talep giriş - konu ve kayıt ol - email

Pagination işlemlerinin eklenmesi: yapıldı
Minimum 1 adet Dosya işleminin yapılması: yapıldı (talep girişi)

