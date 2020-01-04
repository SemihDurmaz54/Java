Uygulama kitap dükkanı için basit bir muhasebe uygulamasıdır. Yer alan fonksiyonlar: 

-Müşteri Ekle (isim ve email sorar. Müşteri id'ye denk gelen Mid'i otomatik atar)

-Kitap Ekle (Kitap ismi ve fiyatını sorar. Kitap isbn'sini otomatik atar)

-Sipariş (Kitaplar tablosundaki kitapları otomatik listeler. Kullanıcının seçtiklerini sepete ekler. Sipariş kısmı eklenecektir)
-Müşterileri Görüntüle (Tüm müşteri listesini, 1 sayfada 5 tane olacak şekilde listeler. Sağ ok ile bir sonraki beşli, sol ok ile bir önceki beşli görüntülenebilir)

-Müşteri Ara (Girilen Mid ile müşteri var mı diye sorgular. Var ise kullanıcı mid, isim ve emailini gösterir. Email değiştirilebilir formatta gösterir. Email kısmında değişiklik yapılıp Onay tuşu ile email güncellenebilir. İptal tuşuyla sayfada sonuçlar temizlenir. Müşteri sil butonu ise müşteriyi müşteri tablosundan siler.

-Fatura (Oluşturulacaktır)

-Ödeme (Oluşturulacaktır)

src > muhasebeprojesi > HomeScreen run edilerek uygulama çalıştırılabilir.
Login.java dosyası şifre ile giriş yapmak için tasarlanmıştır. Geliştirilecektir.

Veritabanı olarak mysql kullanılmıştır. localhost:3306 portunda bulunan "deneme1" adlı veritabanına "root" ile bağlanılmıştır. Şifresi yoktur .
