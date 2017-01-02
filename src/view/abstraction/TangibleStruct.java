package view.abstraction;

/**
 * When you use a windows, it contains different views. This is 
 * an interface containing methods to create and update correctly those
 * views.
 * @author bpotiron
 *
 * @param <T> the view (could be a container, a JPanel or whatever you want)
 */
public interface TangibleStruct<T> extends ImageSize {

	/**
	 * This method create the view by creating all the elements used by it and
	 * place them at the right place.
	 */
	public void creationOfStructure();
	
	/**
	 * this method update the structure : it update all the elements composing
	 * the structure of the view. For the update, the data stored during the
	 * creation of the view are used.
	 */
	public void updateStructure();
	
	/**
	 * This method return the view after an update. The container composed by
	 * this view (or more) is automatically updated.
	 * @return the view T composed by all the elements created before
	 */
	public T getView();
}
