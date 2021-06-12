# CoffeeOrderShopRestAPIService

Bu Dosya CoffeeOrderShopRestAPIService için Api dokümantasyonu için hazırlanmıştır.
Dokümantasyon için SwaggerUI kullanılmıştır.

![swaggerui](https://user-images.githubusercontent.com/28485584/121779577-18bcc980-cba5-11eb-8fe7-9b73288b81bc.PNG)

Uygulama toplamda 3 adet endpoint servisi bulunmaktadır.Bunlar resimde yer alan şu isteklerdir;

<b> localhost:8080/api/coffeeorder/allCoffees </b> - getAllCoffees methodu <br/>
<b> localhost:8080/api/coffeeorder/createCoffeeOrder/{name}  </b>- createCoffeeOrder methodu<br/>
<b> localhost:8080/api/coffeeorder/getCoffeePrice/{name} </b> - getCoffeePrice methodu <br/>

allCoffees isteği ve getCoffeePrice/{name} isteği <i> GET </i> methodu için çalışırken <br/>
createCoffeeOrder/{name} isteği <i> POST </i> methodu için kullanılmaktadır.

<b> Uç noktaların beklediği parametreler </b>

localhost:8080/api/coffeeorder/createCoffeeOrder/{name}  için name parametresi zorunlu alandır.
localhost:8080/api/coffeeorder/getCoffeePrice/{name} için name parametresi zorunlu alandır.

<b> Uç noktaların döndürebileceği değerler ve formatı </b>

Uç noktalar JSON verisi olarak bize değer dönmektedir

<b> Uç noktalar ve Kimlik Doğrulama </b>

Uç noktalar için kimlik doğrulama gerekmiyor.

<b> Uç noktalar ve Rate Limit</b>

Uç noktalar için şu an için bir rate limit bulunmamaktadır.

<b> Örnek İstekler ve Yanıtları: </b> 

<b> localhost:8080/api/coffeeorder/allCoffees </b> isteği ile Kullanıcı önceden belirlenmiş kahve türlerinin listesini alabilmektedir.

![getAllCoffees](https://user-images.githubusercontent.com/28485584/121780093-78b46f80-cba7-11eb-86df-517e56a530c7.PNG)

[
  {
    "id": 1,
    "coffeeName": "ESPRESSO",
    "coffeePrice": 7
  }, <br/>
  {
    "id": 2,
    "coffeeName": "Double Espresso",
    "coffeePrice": 12
  },<br/>
  {
    "id": 3,
    "coffeeName": "Americano",
    "coffeePrice": 12
  },<br/>
  {
    "id": 4,
    "coffeeName": "Cappuccino",
    "coffeePrice": 12
  },<br/>
  {
    "id": 5,
    "coffeeName": "Caffe Latte",
    "coffeePrice": 13
  },<br/>
  {
    "id": 6,
    "coffeeName": "Mocha",
    "coffeePrice": 10
  },<br/>
  {
    "id": 7,
    "coffeeName": "Hot Water",
    "coffeePrice": 3
  }<br/>
]

<b> localhost:8080/api/coffeeorder/getCoffeePrice/Americano </b> isteği ile Kullanıcı önceden belirlenmiş bir kahve türüne ait fiyat bilgisini öğrenebilmektedir.

![coffeeOfferprice](https://user-images.githubusercontent.com/28485584/121780258-363f6280-cba8-11eb-9416-33ea21f2b9eb.PNG)

Örneğin Americano kahvesinin fiyatı 12 ₺ dır.

<b> localhost:8080/api/coffeeorder/getCoffeePrice/WhiteChocalateMocha </b> isteği gibi  Kullanıcı sistemde olmayan bir kahvenin fiyatını öğrenmek istediğinde aşağıdaki şekilde bir hata mesajı ile karşılaşır.

![coffeeOfferpriceNotHave](https://user-images.githubusercontent.com/28485584/121780422-e614d000-cba8-11eb-849d-0822d85062e0.PNG)


<b> localhost:8080/api/coffeeorder/createCoffeeOrder/Mocha </b> isteği ile Kullanıcı Mocha siparişi verdiğinde listedeki tariflere göre hazırlanır ve tüketilen hammadde bilgisi 
(hammadde ve miktar olarak) kullanıcıya aşağıdaki gibi geri bildirilir.

![orderCommit](https://user-images.githubusercontent.com/28485584/121780539-7d7a2300-cba9-11eb-8b5c-746dc91b0f46.PNG)

<b> localhost:8080/api/coffeeorder/createCoffeeOrder/Mocha </b> isteği ile Kullanıcı Mocha siparişi verdiğinde listedeki tariflere göre hazırlanır ve tüketilen hammadde bilgisi 
(hammadde ve miktar olarak) kullanıcıya aşağıdaki gibi geri bildirilir.

<b> localhost:8080/api/coffeeorder/createCoffeeOrder/Caffe%20Latte </b> isteği ile Kullanıcı Caffee Latte siparişi verdiğinde listedeki tariflere göre hazırlanır ve kahve sisteminde Caffe Latte hazırlamak için gerekli olan hammade yetersiz ise aşağıdaki şekilde kullanıcıya bilgi verilir.

![notenough](https://user-images.githubusercontent.com/28485584/121780851-deeec180-cbaa-11eb-9ddb-1256584e91d8.PNG)








