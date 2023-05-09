package compiladores;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import compiladores.compiladoresParser.AsignacionContext;
import compiladores.compiladoresParser.ProgramaContext;

public class Escucha extends compiladoresBaseListener {
    private Integer nodos = 0;
    private Integer tokens = 0;
    private Integer errors = 0;

    @Override
    public void enterPrograma(ProgramaContext ctx) {
        System.out.println("Comienza el parsing...");
        super.enterPrograma(ctx);
    }

    @Override
    public void exitPrograma(ProgramaContext ctx) {
        super.exitPrograma(ctx);
        System.out.println("Fin de la compilacion");
        System.out.println(" - Se visitaron " + nodos + " nodos");
        System.out.println(" - Hay " + tokens + " tokens");
        System.out.println(" - Se encontraron " + errors + " errores");
    }

    @Override
    public void enterAsignacion(AsignacionContext ctx) {
        System.out.println("\tNueva asignacion: |" + ctx.getText()
                                + "| - hijos = " + ctx.getChildCount());
        super.enterAsignacion(ctx);
    }

    @Override
    public void exitAsignacion(AsignacionContext ctx) {
        super.exitAsignacion(ctx);
        System.out.println("\t  '--> fin asignacion: |" + ctx.getText()
                                + "| - hijos = " + ctx.getChildCount());
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        nodos++;
        super.enterEveryRule(ctx);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        errors++;
        super.visitErrorNode(node);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        tokens++;
        super.visitTerminal(node);
    }
    
}
