package newrelic.agent.troubleshooting.transactions;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;

public class Transaction17 implements Transaction {

    @Trace(dispatcher = true)
    public void startTransaction() {
        System.out.println("newrelic.agent.troubleshooting.transactions.Transaction17: starting a transaction");

        firstMethod();
    }

    private void firstMethod() {
        System.out.println("firstMethod");
        NewRelic.getAgent().getTransaction().startSegment("firstSegment");
        secondMethod();
    }

    private void secondMethod() {
        System.out.println("secondMethod");
        NewRelic.getAgent().getTransaction().startSegment("secondSegment");
    }
}
