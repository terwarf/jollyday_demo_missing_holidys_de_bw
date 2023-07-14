package org.example;

import de.focus_shift.Holiday;
import de.focus_shift.HolidayManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Set;

public class Main
{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        HolidayManager holidayManager = HolidayManager.getInstance();
        Set<Holiday> days = holidayManager.getHolidays(
                LocalDate.of(2023,1,1),
                LocalDate.of(2023,12,30),
                "de", "bw"
        );

        // There should be 12 Holidays for Baden-Württemberg, see
        // https://im.baden-wuerttemberg.de/de/service/feiertage
        logger.info(days.size() + " of 12 days found:");

        for( Holiday tag: days )
        {
            logger.info( tag.toString() );
        }

        // Test single Dates:

        // Fixed: 6th of january
        logger.info( "Heilige drei Könige: " +
                holidayManager.isHoliday(LocalDate.of(2023, 1, 6), "de", "bw") );

        // Moving: 60 days after Christ's resurrection day
        logger.info( "Fronleichnam: " +
                holidayManager.isHoliday(LocalDate.of(2023, 6, 8), "de", "bw") );
    }
}