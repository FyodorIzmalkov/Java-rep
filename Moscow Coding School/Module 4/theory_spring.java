import java.beans.BeanProperty;

import javax.management.modelmbean.RequiredModelMBean;

import org.graalvm.compiler.lir.CompositeValue.Component;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

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

<bean id="courseService" class="com.codingschool.spring.CourseService">
</bean>  - создаем что бы появился бин а внедрять будет через @Autowired
бин должен быть подключен что бы конфиги работали

CourseService courseService = applicationContext.getBean("courseService", CourseService.class);
courseService.getCourses().forEach(c->System.out.println(c.getName()));

Стереотипы  (аннотации)
@Component 
используется для обозначения Spring компонентов без XML конфигурации
- применяется к классам
- служит универсальным стереотипом для каждого управляемого Spring компонента
- рекомендуется использовать более конкретные стереотипы
- @Service
- @Repository
- @Controller
Что бы автоматически регистрировать бины через аннотации, необходимо указать следующую команду в конфигурации контейнера
<context:component-scan base-Ыpackage="ru.codingschool.project.beans"/>

Это избавляет нас от необходимости прописывать ссылку на сервис

Области видимости бинов

Синглтон - по умолчанию, экземпляр единственного бина в контейнере
- только один экземпляр бина создается
- один и тот же экземпляр бина внедряется во все объекты

Прототип - совершенно новый экземпляр бина создается каждый раз когда он внедряется в другой бин
или запрашивается через getBean().

<bean id="accountDao" class="..."
	scope="prototype" />   // обязательно 

	<bean id="person" class="..."
		scope="prototype">
		<property name="course" ref="springCourse"/> //каждый персон будет записан на курс
	</bean>

	Person person = applicationContext.getBean("person", Person.class);
	person.setName("Vadim");
	System.out.println(person.getName());
	System.out.println(person.getCourse().getName());
	Получим в терминале имя - вадим, которое мы задали и курс SpringCourse который задался в апликейшнконтексте

	Конфигурация на основе кода Java
	Мы можем непосредственно в нашем коде создавать бины

	@Configuration
	public class BeanConfig{
		@Bean
		public ExampleBean bean(){
			ExampleBean exampleBean = new ExampleBean();
			exampleBean.setA(1);
			return exampleBean;
		}
	}

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
	ExampleBean exampleBean = context.getBean("bean", ExampleBean.class);
	System.out.println(exampleBean.getA());

	@Configuration 
	@ComponentScan // автоматом просканирует текущий пакет и поищет классы помеченные стереотипом
	public class Application{
		@Bean
		MessageService mockMessageService(){
			return new MessageSerice(){
				public MessageService(){
					String getMessage(){
						return "Hello world!";
					}
				}
			}
		}
	}

	public interface MessageService{
		String getMessage();
	}
	@Component
	public class MessagePrinter{
		@Autowired
		private MessageService service; // сюда внедрится ссылка

		public void printMessage(){
			System.out.println(service.getMessage());
		}
	}

	Можем разбивать конфигурацию на несколько классов

	@Configuration
	public class ConfigBean1{
		@Bean
		public Bean1 bean1(){
			return new Bean1();
		}
	}

	@Configuration
	@Import(ConfigBean1.class) // подключает первый конфиг
	public class ConfigBean2{
		@Bean
		public Bean2 bean2(){
			return new Bean2();
		}
	}

	@Configuration
	@ImportResourse("classpath:application-context.xml")
	@PropertySource("classpath:jdbc.propertities")
	public class AppConfig{
		@Value("${jdbc.url}") // внедрится из файла jdbc.propertities
		private String url;

		@Value("${jdbc.username}")
		private String username;

		@Value ("${jdbc.password}")
		private String password;
	}

	Spring Boot