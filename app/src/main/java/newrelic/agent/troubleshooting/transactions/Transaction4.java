package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;

public class Transaction4 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction4: starting a transaction");
        Token token = NewRelic.getAgent().getTransaction().getToken();
        firstMethod(token);
    }

    @Trace
    private void firstMethod(Token token) {
        System.out.println("firstMethod");
        token.linkAndExpire();
    }
}
