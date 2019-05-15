package base;

import base.store.view.OnlineStore;

public class Main {

    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        onlineStore.start();
    }
}
