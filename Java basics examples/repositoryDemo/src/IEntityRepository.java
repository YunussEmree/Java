public interface IEntityRepository<T extends IEntity> { //IEntity implement etmeyen objeleri kabul etmeyecek
    void add(T entity);
    void delete(T entity);
    void update(T entity);
}
