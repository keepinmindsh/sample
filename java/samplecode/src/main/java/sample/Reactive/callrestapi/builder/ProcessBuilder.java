package sample.Reactive.callrestapi.builder;


import sample.Reactive.callrestapi.command.Command;
import sample.Reactive.callrestapi.vo.ParameterVO;

public class ProcessBuilder<T> {

    private final ParameterVO parameterVO;
    private final String url;
    private final String path;
    private final Command command;

    public static class Builder<T> {
        private ParameterVO parameterVO;
        private String url;
        private String path;
        private Command command;

        public void setPath(String path) {
            this.path = path;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setParameterVO(ParameterVO parameterVO) {
            this.parameterVO = parameterVO;
        }

        public void setCommand(Command<T> command) {
            this.command = command;
        }

        public ProcessBuilder build(){
            return new ProcessBuilder(this);
        }
    }

    private ProcessBuilder(Builder builder){
        this.parameterVO = builder.parameterVO;
        this.path = builder.path;
        this.url = builder.url;
        this.command = builder.command;
    }

    public T callCommandProcess(){
        try {
            return (T) command.execute(this.url, this.path, this.parameterVO);
        } catch (Exception e) {
            return null;
        }
    };
}
