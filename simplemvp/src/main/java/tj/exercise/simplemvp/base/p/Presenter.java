package tj.exercise.simplemvp.base.p;

public interface Presenter<V, W> {

	void attachView(V view);

	void setViewWrapper(W viewWrapper);

	void detachView();

}
