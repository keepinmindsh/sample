package sample.Reactive.callrestapi.command;

import sample.Reactive.callrestapi.vo.ParameterVO;

public interface Command<T> {
    public T execute(String url, String path, ParameterVO parameterVO) throws Exception;
}
