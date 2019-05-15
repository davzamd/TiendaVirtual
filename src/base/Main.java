package base;

import base.store.control.StoreManager;

public class Main {

    public static void main(String[] args) {
        StoreManager onlineStore = new StoreManager();
        onlineStore.start();
    }
}
