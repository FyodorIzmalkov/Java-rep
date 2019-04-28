import javax.management.modelmbean.RequiredModelMBean;

Sprimg Framework
Фреймворк определяет как ваш код устроен и в нужные моменты вызывает ваш код
Стандартизированная архитектура
Традиционный подход: зависимость внутри кода.
Spring - внедрение зависимостей
IoC объектам ничего не известно друг о друге

Person
POJO - plain old java object

public class Person{
	private String name;
	private Course course;
}

public class Course{
	private String name;
}

public class Timeslot{
	private Course course;
}

COURSE -> application-context.xml
<bean id ="smith" class="Person">
	<property name="name" value="John Smith"/>
	<property name="course" ref="springCourse"/>
</bean>

<bean id = "springCourse" class="Course">
	<property name="name" value="Spring"/>
</bean>

<bean i="springCourseTimeslot" class="Timeslot">
	<property name="course" ref="springCourse"/>
</bean>

Внедрение зависимостей

public class TutorialApplication{
	private Timeslot timeslot;
}

<bean id="TutorialApplication" class="TutorialApplication">
	<property name="timeslot" ref="springCourseTimeslot"/>
</bean>

TutorialApplication ссылается на springCourseTimeslot ссылается на springCourse ссылается на Smith

public class Main{
	public static void main(String args[]){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		TutorialApplication tutorialApplication = context.getBean("tutorialApplication", TutorialApplication.class);
		System.out.println(tutorialApplication.getTimeslot().getCourse().getName());
		context.close();
	}
}

Основой Spring является паттерн инверсии управления (IoC inversion of control) или внедрение зависимостей (DI).
Основная идея - отделить зависимость компонентов приложения от определенной реализации и делегировать DI - контейнеру 
права на управление созданием и инициализацией классов
Dependency Injection - объекты сами друг с другом не связанные

Преимущества IoC
- управление зависимостями и применение изменений без перекомпиляции // поменял XML обновить applicationcontext и тогда создадутся все объекты которые туда входят 
- простое повторное использование классов или компонентов // максимально простые классыы
- простое модульное тестирование // объект независим ни от чего
- более чистый код (классы не инициируют вспомогательные объекты) // вся инициализация вынесена в XML
- особенно рекомендуется для вставки в DI - контейнер объектов, реализация которых может измениться

Dependency Injection
- контейнер создает необходимые объекты и управляет их временем жизни
- Person и Course не зависят от каких либо внешних библиотек
- контекст приложения документирует системные и объектные зависимости
- очень легко вносить изменения в объектные зависимости в системе - достаточно изменить конфигурацию, при этом перекомпиляция не нужна

Конфигурация на основе аннотаций

конфигурацию контейнера в спринг можно выполнить с помощью аннотаций

Базовые:
- autowired
- Required
- component

Для конфигураций на основе аннотаций в конфиг Spring контейнера надо указать следующее:
<context:annotation:config/> (до бинов)

@autowired
применяется для метода изменения значений свойства бина

public class JavaSchool{
	private Course course;

	@Autowired
	public void setCourse(Course course){
		this.course = course;
	}
}

Внедрение идет по типу
@Autowired
@Qualifier("springCourse") - позволяет внедрить по имени
private Course course;