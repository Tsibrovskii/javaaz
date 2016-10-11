package ru.tsibrovskii.models;

/**
 * Класс предназначен для хранения сущности типа "заявка".
 * Приватное поле <b>id</b> предназначено для хранения идентификатора сущности.
 * Публичные поля <b>name</b>, <b>description</b>, <b>create</b> используются для хранения
 * имени, описания и даты создания сущности, соответственно.
 */

public class Item {

    private String id;

    public String name;
    public String description;
    public long create;

    public Comment[] comments = new Comment[1];

    /**
     * Конструктор класса <b>Item</b> по умолчанию.
     */
    public Item() {
    }

    /**
     * Конструктор класса <b>Item</b> с тремя входными параметрами.
     * @param name имя заявки
     * @param description описание заявки
     * @param create дата создания заявки
     */
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Метод, возвращающий имя заявки.
     * @return <b>name</b> (имя заявки)
     */
    public String getName() {
        return this.name;
    }

    /**
     * Метод, возвращающий описание заявки.
     * @return <b>description</b> (описание заявки)
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Метод, возвращающий дату создания заявки.
     * @return <b>create</b> (дата создания заявки)
     */
    public long getCreate() {
        return this.create;
    }

    /**
     * Метод, возвращающий <b>id</b> заявки.
     * @return <b>id</b> (id заявки)
     */
    public String getId() {
        return this.id;
    }

    /**
     * Метод, присваивающий <b>id</b> заявке.
     * @param id (id заявки)
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Метод для добавления комментариев к заявке
     * @param comment комментарий
     */
    public void addComment(Comment comment) {
        for (int i = 0; i < this.comments.length; i++) {
            if (this.comments[i] == null) {
                this.comments[i] = comment;
                return;
            }
        }
        Comment[] bigcomments = new Comment[this.comments.length + 1];
        for (int j = 0; j < comments.length; j++) {
            bigcomments[j] = comments[j];
        }
        bigcomments[comments.length] = comment;
        this.comments = bigcomments;
    }

    /**
     * Метод для удаления комментария к заявке
     * @param pos номер удаляемого комментария
     */
    public void delComment(int pos) {
        comments[pos] = null;
    }
}