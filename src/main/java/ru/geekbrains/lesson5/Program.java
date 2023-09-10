package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 3D графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     * <p>
     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
     * Какие задачи можно делать – функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация .., в файловой системе компьютера).
     * <p>
     * Предложить варианты связывания всех уровней – сценарии использования. 3-4 сценария.
     * Сквозная функция – создать новую 3D модель, сделать рендер для печати на принтере…
     */
    public static void main(String[] args) {
        Editor3D editor3D = new Editor3D();
        boolean f = true;
        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("8. Добавить текстуру в базу данных");
            System.out.println("9. Удалить текстуру из базы данных");
            System.out.println("10. Добавить модель в базу данных");
            System.out.println("11. Удалить модель из базы данных");
            System.out.println("12. Добавить текстуру в модель");
            System.out.println("13. Удалить текстуру из модели");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.print("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);

                            break;
                        case 2:
                            editor3D.saveProject();
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            editor3D.renderAll();
                            break;
                        case 7:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 8:
                            if (editor3D.addTexture(new Texture()))
                                System.out.println("Текстура успешно добавлена.");
                            else
                                System.out.println("Текстура не добавлена!");
                            break;
                        case 9:
                            System.out.print("Укажите номер текстуры: ");
                            if (scanner.hasNextInt()) {
                                int textureNo = scanner.nextInt();
                                scanner.nextLine();
                                if (editor3D.removeTexture(textureNo))
                                    System.out.println("Текстура успешно удалена.");
                                else
                                    System.out.println("Удаление текстуры не произведено!");
                            } else {
                                System.out.println("Номер текстуры указан некорректно.");
                            }
                            break;
                        case 10:
                            if (editor3D.addModel(new Model3D()))
                                System.out.println("Модель успешно добавлена.");
                            else
                                System.out.println("Модель не добавлена!");
                            break;
                        case 11:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                if (editor3D.removeModel(modelNo))
                                    System.out.println("Модель успешно удалена.");
                                else
                                    System.out.println("Удаление модели не произведено!");
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 12:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                if (editor3D.addTextureToModel(modelNo))
                                    System.out.println("Текстура успешно добавлена в модель.");
                                else
                                    System.out.println("Текстура не добавлена в модель!");
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 13:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Укажите номер текстуры: ");
                                if (scanner.hasNextInt()) {
                                    int textureNo = scanner.nextInt();
                                    scanner.nextLine();
                                    if (editor3D.removeTextureFromModel(modelNo, textureNo))
                                        System.out.println("Текстура успешно удалена из модели.");
                                    else
                                        System.out.println("Текстура не удалена из модели!");
                                } else System.out.println("Номер текстуры указан некорректно.");


                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }
}

/**
 * UI (User Interface)
 */
class Editor3D implements UILayer {

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;

    private DatabaseAccess databaseAccess;

    private Database database;


    private void initialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        initialize();
        System.out.println("Проект успешно открыт.");
    }

    @Override
    public void showProjectSettings() {

        // Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");

    }

    private void checkProjectFile() {
        if (projectFile == null)
            throw new RuntimeException("Файл проекта не определен.");
    }

    @Override
    public void saveProject() {

        // Предусловие
        checkProjectFile();

        database.save();
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i + 1);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {

        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i + 1);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        // Предусловие
        checkProjectFile();


        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public void renderModel(int i) {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Номер модели указан некорректною.");
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    @Override
    public boolean addTexture(Texture texture) {
        checkProjectFile();
        return businessLogicalLayer.addTexture(texture);
    }

    @Override
    public boolean removeTexture(int id) {
        // Предусловие
        checkProjectFile();

        if (id < 0)
            throw new RuntimeException("Номер текстуры указан некорректною.");

        for (Texture texture : businessLogicalLayer.getAllTextures()) {
            if (texture.getId() == id)
                return businessLogicalLayer.removeTexture(texture);
        }
        System.out.println("Номер текстуры указан некорректною.");
        return false;
    }

    @Override
    public boolean addModel(Model3D model3D) {
        checkProjectFile();
        return businessLogicalLayer.addModel(model3D);
    }

    @Override
    public boolean removeModel(int modelNo) {
        // Предусловие
        checkProjectFile();

        if (modelNo < 0)
            throw new RuntimeException("Номер модели указан некорректною.");

        for (Model3D model : businessLogicalLayer.getAllModels()) {
            if (model.getId() == modelNo)
                return businessLogicalLayer.removeModel(model);
        }
        System.out.println("Номер модели указан некорректною.");
        return false;
    }

    @Override
    public boolean addTextureToModel(int modelNo) {
        // Предусловие
        checkProjectFile();
        for (Model3D model : businessLogicalLayer.getAllModels()) {
            if (model.getId() == modelNo) {
                model.getTextures().add(new Texture());
                return true;
            }
        }
        System.out.println("Модель не найдена!");
        return false;
    }

    @Override
    public boolean removeTextureFromModel(int modelNo, int textureNo) {
        // Предусловие
        checkProjectFile();
        for (Model3D model : businessLogicalLayer.getAllModels()) {
            if (model.getId() == modelNo) {
                for (Texture texture : model.getTextures()) {
                    if (texture.getId() == textureNo) {
                        model.getTextures().remove(texture);
                        return true;
                    } else {
                        System.out.println("Текстура не найдена в модели!");
                        return false;
                    }

                }
            }
        }
        System.out.println("Модель не найдена!");
        return false;
    }
}

/**
 * Интерфейс UI
 */
interface UILayer {

    void openProject(String fileName);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);

    boolean addTexture(Texture texture);

    boolean removeTexture(int id);

    boolean addModel(Model3D model3D);

    boolean removeModel(int modelNo);

    boolean addTextureToModel(int modelNo);

    boolean removeTextureFromModel(int modelNo, int textureNo);
}

/**
 * Реализация Business Logical Layer
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;


    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels())
            processRender(model);
    }

    @Override
    public boolean addTexture(Texture texture) {
        return databaseAccess.addEntity(texture);
    }

    @Override
    public boolean removeTexture(Entity entity) {
        return databaseAccess.removeEntity(entity);
    }

    @Override
    public boolean addModel(Model3D model3D) {
        return databaseAccess.addEntity(model3D);
    }

    @Override
    public boolean removeModel(Entity entity) {
        return databaseAccess.removeEntity(entity);
    }

    private Random random = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

/**
 * Интерфейс BLL (Business Logical Layer)
 */
interface BusinessLogicalLayer {
    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();

    boolean addTexture(Texture texture);

    boolean removeTexture(Entity entity);

    boolean addModel(Model3D model3D);

    boolean removeModel(Entity entity);
}

/**
 * Реализация DAC
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                models.add((Texture) entity);
            }
        }
        return models;
    }

    @Override
    public boolean addEntity(Entity entity) {
        return editorDatabase.getAll().add(entity);
    }

    @Override
    public boolean removeEntity(Entity entity) {
        return editorDatabase.getAll().remove(entity);
    }
}

/**
 * Интерфейс DAC
 */
interface DatabaseAccess {
    boolean addEntity(Entity entity);

    boolean removeEntity(Entity entity);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}

/**
 * Database
 */
class EditorDatabase implements Database {

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры и т. д)
    }

    @Override
    public void save() {
        //TODO: Сохранение текущего состояния всех сущностей проекта
    }

    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model3D = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3D.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3D);
    }

}

/**
 * Интерфейс БД
 */
interface Database {
    void load();

    void save();

    Collection<Entity> getAll();
}

/**
 * 3D модель
 */
class Model3D implements Entity {

    private static int counter = 10000;
    private int id;

    private Collection<Texture> textures = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    {
        id = ++counter;
    }

    public Model3D() {

    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return String.format("3DModel #%d", id);
    }

}

/**
 * Текстура
 */
class Texture implements Entity {

    private static int counter = 50000;

    private int id;

    {
        id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%d", id);
    }
}

/**
 * Сущность
 */
interface Entity {

    int getId();
}

/**
 * Файл проекта
 */
class ProjectFile {

    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public ProjectFile(String fileName) {

        this.fileName = fileName;
        //TODO: Загрузка настроек проекта из файла

        setting1 = 1;
        setting2 = "...";
        setting3 = false;
    }

    public String getFileName() {
        return fileName;
    }

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean getSetting3() {
        return setting3;
    }
}
