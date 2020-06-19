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
