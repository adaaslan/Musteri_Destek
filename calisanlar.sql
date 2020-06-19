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

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
