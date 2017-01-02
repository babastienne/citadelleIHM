package view.abstraction;

/**
 * This interface is used by a window. When you create a window composed by
 * one or more view(s), you should use this interface who provides the
 * basic method used for the update of the structure.
 * @author bpotiron
 *
 * @param <T>
 */
public interface ContainerStruct<T> {
	
	public void creationWindow(T t);
	
	public void updateStructure(T t);
}
