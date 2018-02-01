# Alkalmazások fejlesztése projekt: Családi TO-DO

A projekt célja egy családi feladat beosztás segítésére használható webes alkalmazás elkészítése.

### Funkcionális Követelmények:
##### Minden felhasználóra vonatkozóan:
* Regisztráció
* Bejelentkezés
* Kijelentkezés
* Taskok létrehozása
* Felhasználó számára létrehozott taskok kipipálása
* Felhasználó álltal létrehozott taskok módosítása
* Felhasználó saját aktív taskjainak a kilistázása

##### Adminisztrátor(ok)ra vonatkozóan:
* Regisztrációhoz szüséges kulcs legenerlása
* Báremly felhasználó taskjainak módosítása
* Báremly felhasználó taskjainak törlése
* Bármely felhasználó törlése
* Minden task kilistázása

### Nem Funkcionális Követelmények:
* Biztonság: 
    - jelszavak hashelése
    - csak egy adminisztrátor álltal legenáralt kulccsal lehet regisztrálni
* Kezelhetőség:
    - csak a felhasználó részére érdekes dolgok jelennek meg
    - Intuitiv felhasználói felület
    
### Szakmai Fogalmak:
* Task: Határidővel ellátott, elvégzendő tevékenység
* Task felépitése ( nem feltétlen sorrendben ):
  - Kiállítás dátuma
  - Határidő dátuma
  - Kiállító felhasználó
  - Feladat leírása
  - Fontosság
  - Teljesített/Nem teljesített
 
### Szerepkörök
* Adminisztrátor: Szülő, több is lehet
* Felhasználó: Szülő vagy gyerek, több is lehet

![db](/db.PNG)
### Adatmodell
![adatmod](/adatfolyam.png)

### Végpontok(tervezett)

|elérés                 |típus      |funkció
|---                    |---        |---
| /api/user/register    | POST      | regisztráció
| /api/user/login       | POST      | bejelentkezés
| /api/user/logout      | POST      | kijelentkezés
| /api/user/tasks       | GET       | user feladatok listája
| /api/user/usertask    | GET       | 1 feladat kérése
| /api/task/tasks       | GET       | összes feladat listázása
| /api/task/edit/id     | PUT       | adott ID-s feladat szerkesztése
| /api/task/delete/id   | DELETE    | adott ID-s feladat törlése


# Megvalósítás

## Fejlesztőkörnyezet

Felhasznált eszközök

-Github: a projekt összefogásához, közös fejlesztéshez
-Node.js: Javascript környezet biztosítása
-Spring Boot: MVC pattern megvalósítása
-Angular: Frontend oldali megvalósítás
-Tyhmeleaf: dinamikus megjelenítés működtetése
-Postman: Backend tesztelés
-H2: adatbázis megvalósítás

Fejlesztőkörnyezet felállítása

-Node.js környezet telepítése 
-Angular Cli telepítése az npm install –g @angular/cli paranccsal 
-maven letöltése, kicsomagolása a PCn, path környezeti változókhoz adás, JAVA_HOME környezeti változó helyes beállítása.

belépés az angular mappába a parancssorban és "ng serve" utasítás kiadása
belépés a spring-boot new mappájába másik parancssori ablakban, majd az "mvnw spring-boot:run" kiadása
a "localhost:port" oldal megnyitása böngészőben

Könyvtár struktúra

Spring-boot new: Backend
controller: Az MVC Controller-ért felelős osztályok helye 
model: Az MVC Modell-ért felelős osztályok helye  
repository: a verzió kontrolt elősegítő osztályok helye 
service: komponensek

![hasznalat](/usecase.PNG)

## Felhasználói dokumentáció

Telepítés: ->Fejlesztői környezet felállítása

Indítás:
- lépjünk be az angular mappájába és adjuk ki az "ng serve" utasítást
- lépjünk be a spring-boot mappájába egy másik parancssori ablakban, adjuk ki az "mvnw spring-boot:run" utasítást
- keressük fel a localhost:4200 oldalt egy tetszőleges böngészőben

Regisztráció, bejelentkezés
Az oldal tartalma bejelentkezés után érhető el. 
Bejelentkezés után elérhetőek az oldal funkciói. 

Kijelentkezés
Az oldalról a Logout funkcióval jelentkezhetünk ki, minden bejelentkezéshez kötött funkcióhoz újra be kell jelentkeznünk. 

Adminisztrátor lehetőségei
Adminisztrátori joggal rendelkező felhasználóknak egy plusz funkciókkkal egészül ki a menü. 
kezdeti admin:
