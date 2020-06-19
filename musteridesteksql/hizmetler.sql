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

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
