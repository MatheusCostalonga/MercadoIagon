package model.bean;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoSingleton {

    private static CarrinhoSingleton instance;
    private List<CarrinhoDTO> carrinhoItens;

    private CarrinhoSingleton() {
        carrinhoItens = new ArrayList<>();
    }

    public static CarrinhoSingleton getInstance() {
        if (instance == null) {
            instance = new CarrinhoSingleton();
        }
        return instance;
    }

    public List<CarrinhoDTO> getCarrinhoItens() {
        return carrinhoItens;
    }

    public void adicionarItem(CarrinhoDTO item) {
        carrinhoItens.add(item);
    }

    public void limparCarrinho() {
        carrinhoItens.clear();
    }

}
