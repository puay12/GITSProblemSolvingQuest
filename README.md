## Overview
- Repository ini berisi kode yang ditulis oleh **Putri Ayu Nisa Az Zahra** untuk menyelesaikan soal-soal problem solving dalam proses rekrutmen posisi **Mobile Developer** di **PT GITS Indonesia**.
- Dikarenakan pengujian kode menggunakan 3 input values, maka Saya buatkan loop untuk input values tanpa harus Run kode berulang-ulang.
- Setiap soal memiliki 1 package yang terdiri dari file program (source code) dan 3 screenshots output dari program.  

## Basis ide penyelesaian **Soal Kedua** :  
- Output akan bernilai "NO" jika opening bracket yang paling dalam tidak **langsung** menemukan pasangannya di karakter selanjutnya. Sehingga kapan pun closing bracket ditemukan **setelah karakter opening bracket**, maka harus sepasang dengan karakter sebelumnya.  
Misalnya setelah karakter ( ditemukan karakter ], maka output akan langsung bernilai "NO" dan loop dihentikan karena seharusnya karakter sebelum ] adalah [.
- Output juga akan bernilai "NO" jika jumlah opening bracket TIDAK SAMA dengan jumlah closing bracket pada *givenString*
  
## Penjelasan detail dari **Soal Kedua**:  
- Algoritma penyelesaian soal berada pada function bernama **identifyBrackets()** dengan parameter *givenString* bertipe String sebagai string yang akan diidentifikasi.
- Pertama, Saya membuat beberapa variabel sebagai kamus yang digunakan sebagai pengetahuan sistem untuk identifikasi karakter bracket, seperti:
  - *__openingBrackets__* -> **Array of Char** : menyimpan karakter apa saja yang termasuk opening brackets -> (, [, dan {
  - *__closingBrackets__* -> **Array of Char** : menyimpan karakter apa saja yang termasuk closing brackets -> ), ], dan }
  - *__bracketPairs__* -> **Map<Char,Char>** : menyimpan pasangan-pasangan bracket -> (), {}, dan []
- Lalu, beberapa variabel sebagai flag untuk menentukan hasil output seperti:
  - *__prevBracket__* -> **Char** : menyimpan karakter sebelumnya
  - *__countOpening__* -> **Int** : menghitung jumlah opening bracket pada *__givenString__*
  - *__countClosing__* -> **Int** : menghitung jumlah closing bracket pada *__givenString__*
- (Line 28-32) Kemudian, setiap karakter pada *__givenString__* diloop dengan **foreach**, setiap iterasi akan dilakukan identifikasi, jika termasuk opening bracket maka akan menambah *__countOpening__*, begitu juga dengan closing bracket akan menambah *__countClosing__*
- (Line 34) Dalam proses loop, jika akhirnya ditemukan satu *__closing bracket__* (apapun jenisnya dan karakter bukan spasi) **directly** setelah karakter opening bracket, maka akan dicek:
  - (Line 35) Jika karakter sebelumnya adalah opening bracket bukan spasi, maka masuk ke pengecekan berikutnya:
    - (Line 36) Jika karakter sebelumnya BUKAN pasangan dari closing bracket (karakter iterasi ini) -> dicek dari *__bracketPairs__* dengan *__prevBracket__* sebagai key, maka loop akan langsung dihentikan dan return "NO".
- Jika ketiga pengecekan tersebut tidak benar, maka akan lanjut ke blok kode berikutnya.
- (Line 42-44) Setiap iterasi pada foreach, *__prevBracket__* akan diisi dengan karakter di iterasi tersebut (current) selama karakter itu bukan spasi.
- Jika loop foreach tidak diberhentikan paksa, setelah loop selesai, dilakukan pengecekan. Jika nilai *__countOpening__* SAMA DENGAN nilai *__countClosing__*, maka output bernilai **"YES"**. Jika tidak, maka output akan bernilai **"NO"**.
