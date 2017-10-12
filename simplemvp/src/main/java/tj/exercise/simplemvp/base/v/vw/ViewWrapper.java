package tj.exercise.simplemvp.base.v.vw;

public interface ViewWrapper<V, D> {
	void attachView(V view);

	void detachView();

	void setBinding(D dataBinding);

	void onBind();
}
