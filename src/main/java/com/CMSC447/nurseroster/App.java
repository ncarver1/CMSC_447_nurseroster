package com.CMSC447.nurseroster;

import com.CMSC447.nurseroster.domain.NurseRoster;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {



        SolverFactory<NurseRoster> solverFactory = SolverFactory.createFromXmlResource(
                "nurseroster/src/main/Resources/nurseRosterSolverConfig.xml");
                // replace with path to nurseRosterSolverConfig.xml

        Solver<NurseRoster> solver = solverFactory.buildSolver();
    }
}
