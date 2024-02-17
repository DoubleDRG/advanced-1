package hello.advanced.trace.callback;

import lombok.extern.slf4j.Slf4j;

public interface TraceCallback<T>
{
    T call();
}
