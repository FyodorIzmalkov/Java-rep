Java JPA - java persistance API
Используется для работы с базаами данных что бы устранить несоответствие реляционной и объектной баз данных
для облегчения синхронизации между ними
Самая популярная - Hibernate

Классы модели с аннотациями JPA

@Entity // сущность мэпится в таблицу
public class CodingSchool{
    @Id
    @GeneratedValue(strategy=GeneratinType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy="codingSchool")
    private List<Course> courses = new ArrayList<>();

    public CodingSchool(){

    }
}


@Entity
        public class Course{
    @Id
    @GeneratedValue(strategy=GeneratinType.AUTO)
    private int id;
    private String name;

    public Course(){

    }

    @ManyToOne
    private CodingSchool codingSchool;

    @OneToMany(mappedBy="course")
    private List<Student> students;
}

@Entity
        public class Student{
    @Id
    @GeneratedValue(strategy=GeneratinType.AUTO)
    private int id;
    private String name;

    public Course(){

    }
    @ManyToOne
    private Course course;

    public Student(){

    }
}
Отношения сущностей
        One-to-Many
        Many-to-One
        Many-to-Many
        One-to-One
Отношения могут быть односторонними или двусторонними
Если отношения односторонние - то одна из сторон управляет другой

Аннотации JPA должны быть указаны:
- либо у свойств - тогда чтение-запись идет через свойства; свойства должны быть public or protected;
- либо у полей - тогда чтение-запись осуществляется непосредственно в поля; поля могут иметь любую видимость

Также необходимо наличие конструктора без параметров
Поддерживается мэппинг коллекций любого типа

EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
em.persist(school);
em.getTransaction().commit(); // при коммите происходит изменение базы данных
em.close();

для того что бы работать с базой данных
устанвить базу данных h2
h2 download - google
либо можно испоьзовать из экстернал либ в спринге
добавить депенденси что оно не просто спрингбутовое приложение но и приложение которое работает как веб сервер

что бы добавить все в базу данных, надо добавить каскадирование
@OneToMany(mappedBy="course", cascade = CascadeType.ALL (можно поставить PERSIST))
private List<Student> students;

Если необходимо сохранять очень большие данные
Поля по умолчанию мэпятся в соответствующие колонки базы данных, однако это может быть настроено с использованием аннотаций
@Column
@Lob

первичный ключ может генерироваться автоматически
@GeneratedValue - генерация первичного ключа

Также можно определить стратегию
@Auto(strategy=GenerationType.AUTO)
@Identity
@Sequence
@Table

Жизненный цикл сущности
после persist() она становится управляемой Managed при первой команде commit или flush она попадает в Database

Каскадные операции
-persist merge remove refresh detach all
- удаление сирот orphans removal
- ленивая и неленивая загрузка - EAGER/LAZY loading

Наследование MappedSuperclass
Стратегии наследования InheritanceType - SINGLE_TABLE - most popular
TABLE_PER_CLASS
JOINED