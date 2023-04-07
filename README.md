# TP2DPBO2023
Saya Muhammad Fikri Kafilli NIM 2107264 mengerjakan TP 2 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Deskripsi Tugas
Buatlah program Java yang terkoneksi dengan database MySQL. Berikut spesifikasi program yang harus dibuat:
Program bebas, kecuali program Mahasiswa dan Book Author
- Terdapat proses Create, Read, Update, dan Delete data
- Terdapat proses Autentikasi (Login, Register) *
- Menggunakan minimal 2 tabel pada database
- Harus terdapat minimal 1 properti gambar pada class yang dibuat (gambar akan ditampilkan pada UI)
- Terdapat pergantian screen pada UI
- Terdapat button navigasi untuk beralih screen
- List data ditampilkan menggunakan card (JPanel)
- contoh card dengan JPanel
- Boleh login dan/atau register. Tidak perlu ada enkripsi password

## Design Program
Pada program ini terdapat 7 class dan yang menjadi ***Main Class*** adalah `login`, berikut detail tiap class :
- `dbConnection` Class ini digunakan untuk melakukan koneksi ke database. Class ini memiliki 2 atribut, yaitu stmt dan conn. Method-method yang ada di class ini digunakan untuk membantu proses query dari aplikasi ke database.

- `Login` -> Class ini mengimplementasikan sebuah frame login untuk page login.

- `JPanelCard` ->  Class ini digunakan untuk menampilkan card-panel yang berisi informasi mengenai game. Class ini memiliki method setPanel() yang digunakan untuk menampilkan daftar game dari suatu perusahaan game developer dalam bentuk Card menggunakan GridLayout, setPanel() untuk menampilkan game, dan setPanel2() untuk menampilkan developer game. Class ini memiliki 4 atribut, yaitu db untuk koneksi ke database dan kode_group, nama_group, foto_group untuk menyimpan data group dari query. 

- `Card` -> Class ini digunakan untuk menampilkan informasi game dalam bentuk kartu (card) pada aplikasi. Kelas Card memiliki beberapa atribut yaitu id_game (id game), db (objek koneksi ke database), dan MainFrame (objek JPanelCard yang merupakan panel utama). Class ini memiliki method setgame untuk mengeset data game dari database untuk ditampilkan di Card.

- `Card2` -> Class ini digunakan untuk menampilkan informasi developer dalam bentuk kartu (card) pada aplikasi. Kelas Card memiliki beberapa atribut yaitu id_dev (id developer), db (objek koneksi ke database), dan MainFrame (objek JPanelCard yang merupakan panel utama). Class ini memiliki method setdeveloper untuk mengeset data developer dari database untuk ditampilkan di Card.

- `addGame` -> Class ini digunakan untuk membuat form untuk memasukkan data game ke dalam database dan untuk melakukan update data game yang sudah ada di dalam database. Class ini memiliki beberapa atribut, yaitu db yang digunakan untuk koneksi ke database, fileImg yang digunakan untuk menyimpan file gambar game yang dipilih oleh pengguna, path yang menyimpan path dari file gambar yang dipilih oleh pengguna, flag yang digunakan untuk menentukan apakah data yang akan dimasukkan merupakan data baru atau data yang akan diupdate, id_game yang menyimpan id dari game yang akan diupdate, nama untuk nama dari game, deskripsi untuk deskripsi dari game, developer yang menyimpan foreign key dari developer, dan MainFrame yang merupakan objek dari JPanelCard dan home page dari aplikasi ini. class ini memiliki 2 method, yaitu Method combobox() digunakan untuk membuat combobox yang berfungsi sebagai dropdown untuk memilih developer dari game tersebut, Method upload() digunakan untuk  menyalin file gambar game yang dipilih oleh pengguna ke dalam folder image pada aplikasi. 

- `addDeveloper` -> Class ini digunakan untuk membuat form untuk memasukkan data developer ke dalam database dan untuk melakukan update data developer yang sudah ada di dalam database. Class ini memiliki beberapa atribut, yaitu db yang digunakan untuk koneksi ke database, flag yang digunakan untuk menentukan apakah data yang akan dimasukkan merupakan data baru atau data yang akan diupdate, id_dev yang menyimpan id dari developer yang akan diupdate, nama untuk nama dari developer, dan founded untuk tahun kapan perusahaan dibentuk, dan MainFrame yang merupakan objek dari JPanelCard dan home page dari aplikasi ini. class ini memiliki 2 method, yaitu Method combobox() digunakan untuk membuat combobox yang berfungsi sebagai dropdown untuk memilih developer dari game tersebut, Method upload() digunakan untuk  menyalin file gambar game yang dipilih oleh pengguna ke dalam folder image pada aplikasi. 

Program juga memiliki folder khusus yaitu `image` untuk menyimpan gambar dari game

## Design GUI
- Form Login

![image](https://user-images.githubusercontent.com/100756191/230579214-acd6fcf5-8fae-4e54-b414-3f77b87c267c.png)


- Form Data Game

![image](https://user-images.githubusercontent.com/100756191/230579329-e3c08c64-9041-426c-b13c-77b74f838697.png)


- Form Data Developer

![image](https://user-images.githubusercontent.com/100756191/230579888-64fc093b-b82a-4767-a8cf-ad9dff6eb486.png)


- JPanel dengan panel game

![image](https://user-images.githubusercontent.com/100756191/230579448-6524058c-edb3-41eb-aacd-449a2e17960d.png)


- JPanel dengan panel developer

![image](https://user-images.githubusercontent.com/100756191/230579552-5cfab256-aecb-48d8-97c6-e1fe20ddf22a.png)


- Form Update Game

![image](https://user-images.githubusercontent.com/100756191/230579807-c7fb1299-38e1-41b4-b049-087a1f624324.png)


- Form Update developer

![image](https://user-images.githubusercontent.com/100756191/230580055-29a2bd00-7545-49a3-99ba-a16d7a0660cd.png)


## Alur Progam
1. User melakukan login dengan username admin dan password admin, program akan mengarahkan ke halaman home.
2. Di halaman home ini, user dapat melakukan add, delete, update, dan berpindah panel.
4. Untuk menambahkan data game, user dapat menekan tombol Add ketika panel menampilkan data game dan program akan menampilkan form untuk data game.
5. Jika sudah selesai mengisi data member, user dapat menekan tombol add untuk menambahkan data ke database.
7. Untuk memperbaharui data game, user dapat menekan tombol edit pada card data game yang ingin di update dan program akan menampilkan form data game tersebut.
8. Untuk menghapus data game, user dapat menekan tombol delete pada card data game yang ingin di delete.
9. Untuk data developer juga sama seperti game (langkah 2-8), dan ketika nama developer di edit maka otomatis pada data game juga akan terubah nama developernya karena tabel game memiliki foreign key yang terhubung pada tabel developer

## Untuk mencoba login bisa gunakan akun berikut
- Username = admin
- password = admin
