var spatialDf = spark.sql(
    """
    SELECT
      business_id,
      ST_Point(CAST(canonical_business.latitude AS Decimal(24,20)), CAST(canonical_business.longitude AS Decimal(24,20))) AS business_location
    FROM canonical_business
    """.stripMargin)


