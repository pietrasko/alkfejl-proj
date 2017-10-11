# Alkalmazások fejlesztése projekt: Családi TO-DO

A projekt célja egy családi feladat beosztás segítésére használható webes alkalmazás elkészítése.

## Funkcionális Követelmények:
#### Minden felhasználóra vonatkozóan:
* Regisztráció
* Bejelentkezés
* Kijelentkezés
* Taskok létrehozása
* Felhasználó számára létrehozott taskok kipipálása
* Felhasználó álltal létrehozott taskok módosítása
* Felhasználó saját aktív taskjainak a kilistázása

#### Adminisztrátor(ok)ra vonatkozóan:
* Regisztrációhoz szüséges kulcs legenerlása
* Báremly felhasználó taskjainak módosítása
* Báremly felhasználó taskjainak törlése
* Bármely felhasználó törlése
* Minden task kilistázása

## Nem Funkcionális Követelmények:
* Biztonság: 
    - jelszavak hashelése
    - csak egy adminisztrátor álltal legenáralt kulccsal lehet regisztrálni
* Kezelhetőség:
    - csak a felhasználó részére érdekes dolgok jelennek meg
    - Intuitiv felhasználói felület
    
## Szakmai Fogalmak:
* Task: Határidővel ellátott, elvégzendő tevékenység
* Task felépitése ( nem feltétlen sorrendben ):
  - Kiállítás dátuma
  - Határidő dátuma
  - Kiállító felhasználó
  - Feladat leírása
  - Fontosság
  - Teljesített/Nem teljesített
 
## Szerepkörök
* Adminisztrátor: Szülő, több is lehet
* Felhasználó: Szülő vagy gyerek, több is lehet
