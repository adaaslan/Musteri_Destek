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

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
