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

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
