package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Segment;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class Transaction19 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction18: starting a transaction");

        Token token = firstMethod();
        secondMethod(token);
    }

    @Trace
    private Token firstMethod() {
        System.out.println("firstMethod");
        Segment firstSegment = NewRelic.getAgent().getTransaction().startSegment("firstSegment");
        Token token = NewRelic.getAgent().getTransaction().getToken();
        firstSegment.end();
        return token;
    }

    @Trace(async = true)
    private void secondMethod(Token token) {
        System.out.println("secondMethod");
        token.linkAndExpire();
    }
}
