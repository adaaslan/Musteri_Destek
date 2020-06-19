-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- musteridestek için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `musteridestek` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `musteridestek`;

-- tablo yapısı dökülüyor musteridestek.aldigiurun
CREATE TABLE IF NOT EXISTS `aldigiurun` (
  `alinan_id` int(11) NOT NULL AUTO_INCREMENT,
  `musteri_id` int(11) NOT NULL,
  `hizmet_id` int(11) NOT NULL,
  PRIMARY KEY (`alinan_id`),
  KEY `FK__musteriler_alinan` (`musteri_id`),
  KEY `FK__hizmetler_alinan` (`hizmet_id`),
  CONSTRAINT `FK__hizmetler_alinan` FOREIGN KEY (`hizmet_id`) REFERENCES `hizmetler` (`hizmet_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__musteriler_alinan` FOREIGN KEY (`musteri_id`) REFERENCES `musteriler` (`musteri_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- musteridestek.aldigiurun: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `aldigiurun` DISABLE KEYS */;
INSERT INTO `aldigiurun` (`alinan_id`, `musteri_id`, `hizmet_id`) VALUES
	(1, 1, 1),
	(2, 4, 1),
	(3, 1, 2);
/*!40000 ALTER TABLE `aldigiurun` ENABLE KEYS */;

-- tablo yapısı dökülüyor musteridestek.calisanlar
CREATE TABLE IF NOT EXISTS `calisanlar` (
  `calisan_id` int(11) NOT NULL AUTO_INCREMENT,
  `calisan_ad` varchar(50) DEFAULT '0',
  `calisan_soyad` varchar(50) DEFAULT '0',
  `calisan_tel` varchar(50) DEFAULT '0',
  `calisan_adres` varchar(50) DEFAULT '0',
  `calisan_mail` varchar(50) DEFAULT '0',
  `hizmet_id` int(11) DEFAULT 0,
  PRIMARY KEY (`calisan_id`),
  KEY `calisan_hizmet_id_fk` (`hizmet_id`),
  CONSTRAINT `calisan_hizmet_id_fk` FOREIGN KEY (`hizmet_id`) REFERENCES `hizmetler` (`hizmet_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- musteridestek.calisanlar: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `calisanlar` DISABLE KEYS */;
INSERT INTO `calisanlar` (`calisan_id`, `calisan_ad`, `calisan_soyad`, `calisan_tel`, `calisan_adres`, `calisan_mail`, `hizmet_id`) VALUES
	(1, 'Ada', 'Aslan', '5305432361', 'Saray mah. Sarayım sok. Battalgazi/Malatya', 'adaaslan@gmail.com', 1),
	(2, 'Ferhat', 'Atmaca', '5321726867', 'Fırat mah. Sedef sok. Battalgazi/Malatya', 'ferhat.atmc@gmail.com', 2),
	(3, 'Rabia', 'Aslan', '5423216773', 'Saray mah. Sümbülüm sok. Battalgazi/Malatya', 'raslan@gmail.com', 1),
	(4, 'Melike', 'Aydın', '5427452547', 'Elmadağ mah. Çimen sok. Şişli/istanbul', 'melike_aydn@gmail.com', 3),
	(5, 'Hilal', 'Yıldırım', '5553365566', '. Şişli/istanbul', 'hilalyildirim@gmail.com', 4);
/*!40000 ALTER TABLE `calisanlar` ENABLE KEYS */;

-- tablo yapısı dökülüyor musteridestek.dosya
CREATE TABLE IF NOT EXISTS `dosya` (
  `dosya_id` int(11) NOT NULL AUTO_INCREMENT,
  `dosya_yolu` text DEFAULT NULL,
  `dosya_ismi` text DEFAULT NULL,
  `dosya_tipi` text DEFAULT NULL,
  `dosya_value` binary(50) DEFAULT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- musteridestek.dosya: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `dosya` DISABLE KEYS */;
INSERT INTO `dosya` (`dosya_id`, `dosya_yolu`, `dosya_ismi`, `dosya_tipi`, `dosya_value`) VALUES
	(10, NULL, 'New Text Document (2).txt', NULL, _binary 0x0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000),
	(11, NULL, 'musteridestek.sql', NULL, _binary 0x0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000),
	(12, NULL, 'New Text Document (2).txt', NULL, _binary 0x0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000),
	(15, NULL, 'New Text Document.txt', NULL, _binary 0x61C3A72070726F6A6579690D0A00000000000000000000000000000000000000000000000000000000000000000000000000),
	(16, NULL, 'New Text Document.txt', NULL, _binary 0x61C3A72070726F6A6579690D0A00000000000000000000000000000000000000000000000000000000000000000000000000),
	(17, NULL, 'New Text Document.txt', NULL, _binary 0x61C3A72070726F6A6579690D0A00000000000000000000000000000000000000000000000000000000000000000000000000);
/*!40000 ALTER TABLE `dosya` ENABLE KEYS */;

-- tablo yapısı dökülüyor musteridestek.hizmetler
CREATE TABLE IF NOT EXISTS `hizmetler` (
  `hizmet_id` int(11) NOT NULL AUTO_INCREMENT,
  `hizmet_adi` varchar(250) DEFAULT '0',
  `hizmet_aciklama` text DEFAULT NULL,
  PRIMARY KEY (`hizmet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- musteridestek.hizmetler: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `hizmetler` DISABLE KEYS */;
INSERT INTO `hizmetler` (`hizmet_id`, `hizmet_adi`, `hizmet_aciklama`) VALUES
	(1, 'TV+', 'Web Tv'),
	(2, 'Lifebox', 'Bulut Hizmeti'),
	(3, 'Dergilik', 'Online Dergiler'),
	(4, 'BİP', 'Mesajlaşma Uygulaması');
/*!40000 ALTER TABLE `hizmetler` ENABLE KEYS */;

-- tablo yapısı dökülüyor musteridestek.kullanici
CREATE TABLE IF NOT EXISTS `kullanici` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ad` varchar(50) DEFAULT NULL,
  `soyad` varchar(50) DEFAULT NULL,
  `calisan_id` int(11) DEFAULT NULL,
  `kullaniciAdi` varchar(50) DEFAULT NULL,
  `sifre` varchar(50) DEFAULT NULL,
  `rol` varchar(50) DEFAULT '',
  `musteri_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_calisan` (`calisan_id`),
  KEY `FK_musteri` (`musteri_id`),
  CONSTRAINT `FK_calisan` FOREIGN KEY (`calisan_id`) REFERENCES `calisanlar` (`calisan_id`),
  CONSTRAINT `FK_musteri` FOREIGN KEY (`musteri_id`) REFERENCES `musteriler` (`musteri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- musteridestek.kullanici: ~6 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` (`id`, `ad`, `soyad`, `calisan_id`, `kullaniciAdi`, `sifre`, `rol`, `musteri_id`) VALUES
	(1, 'rabia', 'aslan', 3, 'raslan', '1234', 'D', NULL),
	(2, 'ayse', 'Kaya', NULL, 'ayilmaz', '1234', 'M', 2),
	(4, 's', 's', NULL, 'ayilmaz@gmail.com', '1234', 'M', 16),
	(5, 'Hilal', 'Dagdeviren', 5, 'hdagd', '1234', 'D', NULL),
	(6, 'ahmet', 'ahmet', NULL, 'ahmet@gmail.com', '12345', 'M', 18),
	(7, 'deniz', 'rasim', NULL, 'deniz@gmail.com', '1234', 'M', 19);
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;

-- tablo yapısı dökülüyor musteridestek.musteriler
CREATE TABLE IF NOT EXISTS `musteriler` (
  `musteri_id` int(11) NOT NULL AUTO_INCREMENT,
  `musteri_ad` varchar(50) DEFAULT '0',
  `musteri_soyad` varchar(50) DEFAULT '0',
  `musteri_mail` varchar(50) DEFAULT '0',
  `musteri_tel` varchar(50) DEFAULT '0',
  PRIMARY KEY (`musteri_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- musteridestek.musteriler: ~14 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `musteriler` DISABLE KEYS */;
INSERT INTO `musteriler` (`musteri_id`, `musteri_ad`, `musteri_soyad`, `musteri_mail`, `musteri_tel`) VALUES
	(1, 'Mehmet', 'Aslan', 'm_aslan@gmail.com', '5302158785'),
	(2, 'Ayşe', 'Kaya', 'aysekaya@gmail.com', '5355816573'),
	(3, 'İnci', 'Özdemir', 'inciozdmr@gmail.com', '5427689158'),
	(4, 'Ahmet', 'Tok', 'tokahmet@gmail.com', '5363228182'),
	(9, 'Hilal', 'Dağ', 'hilaldgdvrn@gmail.com', NULL),
	(10, 'Hilal', 'Dağ', 'hilaldgdvrn@gmail.com', NULL),
	(11, 'Hilal', 'Dağ', 'hilaldgdvrn@gmail.com', NULL),
	(12, 'Hilal', 'Dağ', 'hilaldgdvrn@gmail.com', NULL),
	(13, 'hilal', 'dağ', 'hdagdeviren@gmail.com', NULL),
	(14, 'hilal', 'dağ', 'hdagdeviren@gmail.com', NULL),
	(15, 'hilal', 'dağ', 'hilal@gmail.com', NULL),
	(16, 's', 's', 'ayilmaz@gmail.com', NULL),
	(18, 'ahmet', 'ahmet', 'ahmet@gmail.com', NULL),
	(19, 'deniz', 'rasim', 'deniz@gmail.com', NULL);
/*!40000 ALTER TABLE `musteriler` ENABLE KEYS */;

-- tablo yapısı dökülüyor musteridestek.talepler
CREATE TABLE IF NOT EXISTS `talepler` (
  `talep_id` int(11) NOT NULL AUTO_INCREMENT,
  `talep_oncelik` varchar(50) DEFAULT '0',
  `talep_durum` varchar(50) DEFAULT NULL,
  `talep_konu` varchar(50) DEFAULT NULL,
  `talep_mesaj` text DEFAULT NULL,
  `talep_tarih` timestamp NULL DEFAULT current_timestamp(),
  `hizmet_id` int(11) DEFAULT NULL,
  `musteri_id` int(11) DEFAULT NULL,
  `dosya_id` int(11) DEFAULT NULL,
  `calisan_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`talep_id`),
  KEY `FK__hizmetler` (`hizmet_id`),
  KEY `FK__musteriler` (`musteri_id`),
  KEY `FK_talepler_dosya` (`dosya_id`),
  KEY `FK_calisanlar` (`calisan_id`),
  CONSTRAINT `FK__calisanlar` FOREIGN KEY (`calisan_id`) REFERENCES `calisanlar` (`calisan_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__hizmetler` FOREIGN KEY (`hizmet_id`) REFERENCES `hizmetler` (`hizmet_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK__musteriler` FOREIGN KEY (`musteri_id`) REFERENCES `musteriler` (`musteri_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_talepler_dosya` FOREIGN KEY (`dosya_id`) REFERENCES `dosya` (`dosya_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;

-- musteridestek.talepler: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `talepler` DISABLE KEYS */;
INSERT INTO `talepler` (`talep_id`, `talep_oncelik`, `talep_durum`, `talep_konu`, `talep_mesaj`, `talep_tarih`, `hizmet_id`, `musteri_id`, `dosya_id`, `calisan_id`) VALUES
	(194, 'Normal', 'Açık', 'Bip bağlantı', 'Wifi kopma sorunu yaşıyorum', '2020-06-04 00:00:00', 4, 1, 12, 1),
	(195, 'Normal', 'Açık', 'lifebox', 'bulut portalı hata veriyor', '2020-06-05 00:00:00', 2, 1, NULL, 2),
	(196, 'Yüksek', 'Açık', 'Web TV bağlatısı', 'Web Tv\' de sürekli yayın kopuyor ve görüntü kalitesi düşüyor.', '2020-06-05 00:00:00', 1, 1, NULL, 1),
	(210, 'Kritik', 'Açık', 'Dergilik uygulamasında sorun', 'Abonesi olduğum ücretli dergileri görüntüleyemiyorum.', '2020-06-07 00:00:00', 3, 19, 17, 4),
	(211, 'Kritik', 'Kapalı', 'Tv+  uygulaması hakkında', 'Uygulama çalışırken tv kanallarının kalitesinde düşüş yaşanıyor.', '2020-06-07 00:00:00', 1, 2, 17, 1),
	(212, 'Normal', 'Kapalı', 'Tv+ uygulamaya giriş', 'Kullanıcı adım ve parolamla login olamıyorum', '2020-06-07 17:03:27', 1, 2, NULL, 3),
	(213, 'Yüksek', 'Kapalı', 'Bip mesaj iletilmiyor', 'Bip uygulamasında mesaj iletilmiyor mesaj da gelmiyor', '2020-06-07 17:09:38', 4, 3, NULL, 5);
/*!40000 ALTER TABLE `talepler` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
