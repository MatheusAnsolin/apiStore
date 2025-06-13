package br.com.store.api.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido { // Atua como a classe Subject 

    private Long id;
    private String status;
    private List<Observer> observers = new ArrayList<>();

    // Construtor
    public Pedido(Long id) {
        this.id = id;
        this.status = "Solicitado"; // Estado inicial
    }

    // Métodos do padrão Observer
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public void detach(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this);
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    // O setStatus é o método que dispara a notificação
    public void setStatus(String novoStatus) {
        this.status = novoStatus;
        System.out.println("Status do pedido " + id + " alterado para: " + novoStatus);
        notifyObservers(); // Chama a notificação 
    }

    // Métodos equals, hashCode e toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}