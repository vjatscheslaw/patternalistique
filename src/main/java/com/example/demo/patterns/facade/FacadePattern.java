package com.example.demo.patterns.facade;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.patterns.builder.BuilderPattern.*;

// Фасад - структурный шаблон проектирования, позволяющий скрыть сложность системы путём
// сведения всех возможных внешних вызовов к одному объекту, делегирующему их соответствующим объектам системы.
// Фасад определяет унифицированный интерфейс более высокого уровня, изолирующего клиентский код от классов подсистемы.
// Фасад "склеивает" классы, реализующие функциональность, но не скрывает их полностью.
// Те, кому нужен доступ к средствам низкого уровня, не лишаются его. - GoF
public class FacadePattern {

	// Обычно, требуется только один фасад, поэтому объекты фасадов часто бывают Одиночками (Singleton) - GoF
	// В нашем примере, мы определяем Фасад VehicleGeneratorFacade, 
	// который будет упрощать создание сразу трёх сложных средств.
    public enum VehicleGeneratorFacade {
    	
    	// Конкретная фабрика часто описывается паттерном Одиночка - GoF
    	// VEHICLES_GENERATOR - Это конкретная фабрика. Абстрактной Фабрики нет, так как я не вижу необходимости воссоздавать всю архитектуру для примера Фасада
    	// Определение абстрактной фабрики мы опускаем, так как нас сейчас интересует Фасад, а не порождающие шаблоны.
    	VEHICLES_GENERATOR; // Экземпляр нашего объекта-фасада я реализовал в виде Одиночки (Singleton)
    	
    	
    	// Паттерн Абстрактная фабрика допустимо использовать вместе с Фасадом, чтобы предоставить интерфейс
    	// для создания объектов подсистем способом, не зависимым от этих подсистем. - GoF
    	// Абстрактная фабрика похожа на строитель в том смысле, что может конструировать сложные объекты.
    	// Основное различие между ними в том, что строитель делает акцент на пошаговом конструировании,
    	// объекта, а абстрактная фабрика - на создании семейств объектов (простых или сложных) - GoF
    	// Здесь очень много написано про Абстрактную фабрику, но при производстве объекта используется конкретная фабрика, 
    	// у которой есть Фабричный Метод, который использует Строитель. 
    	
    	// Фабричный метод. Классы Абстрактной Фабрики часто реализуются Фабричными Методами - GoF
    	public List<Vehicle> generateFrenchVehicles() {
    		List<Vehicle> resultList = new ArrayList<>();
    		resultList.add(new CarBuilder().manufacturer("Peugeot").build()); // Наш фабричный метод прибегает, в свою очередь, к паттерну Строитель
    		resultList.add(new TruckBuilder().manufacturer("Peugeot").transmission(Transmission.AUTOMATIC).build());
    		resultList.add(new MotorbikeBuilder().manufacturer("Peugeot").maxSpeed(90).transmission(Transmission.AUTOMATIC).build());
    		return resultList;
    	}
    }
}
