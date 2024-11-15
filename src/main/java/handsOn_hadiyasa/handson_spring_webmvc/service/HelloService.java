package handsOn_hadiyasa.handson_spring_webmvc.service;

public interface HelloService {
    /**
     * Biasanya logic dari aplikasi bisa ditulis langsung di dalam controller
     * Namun programmer Java biasanya menggunakan layer service untuk mengatur logic jalannya aplikasi
     *
     * Salah satu best practice yang digunakan adalah dengan menggunakan interface untuk service.
     * Hal ini bertujuan jika ada perubahan pada kelas yang mengimplementasi interface, maka tidak berengaruh
     * kepada kelas yang menggunakan interface
     * */

    String hello(String name);
}
