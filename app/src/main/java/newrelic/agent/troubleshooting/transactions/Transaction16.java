package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class Transaction16 implements Transaction {

    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction16: starting a transaction");

        Token token = firstMethod();
        Token token2 = secondMethod();

        thirdMethod(token, token2);
    }

    @Trace(dispatcher = true)
    private Token firstMethod() {
        System.out.println("firstMethod");
        return NewRelic.getAgent().getTransaction().getToken();
    }

    @Trace(dispatcher = true)
    private Token secondMethod() {
        System.out.println("secondMethod");
        return NewRelic.getAgent().getTransaction().getToken();
    }

    @Trace(async = true)
    private void thirdMethod(Token token, Token token2) {
        token.linkAndExpire();
        token2.linkAndExpire();
    }
}
