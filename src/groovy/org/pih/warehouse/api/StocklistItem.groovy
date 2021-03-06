package org.pih.warehouse.api

import org.pih.warehouse.requisition.RequisitionItem

class StocklistItem {

    RequisitionItem requisitionItem
    Integer monthlyDemand

    String stocklistId
    Integer maxQuantity

    static StocklistItem createFromRequisitionItem(RequisitionItem requisitionItem) {
        Integer replenishmentPeriod = requisitionItem?.requisition?.replenishmentPeriod
        Integer monthlyDemand = replenishmentPeriod ? Math.ceil(((Double) requisitionItem.quantity) / replenishmentPeriod * 30) : null

        return new StocklistItem(requisitionItem: requisitionItem, monthlyDemand: monthlyDemand)
    }

    Map toJson() {
        return [
                "requisitionItem.id": requisitionItem?.id,
                stocklistId: requisitionItem?.requisition?.id,
                name: requisitionItem?.requisition?.name,
                "location.id": requisitionItem?.requisition?.origin?.id,
                "location.name": requisitionItem?.requisition?.origin?.name,
                "locationGroup.id": requisitionItem?.requisition?.origin?.locationGroup?.id,
                "locationGroup.name": requisitionItem?.requisition?.origin?.locationGroup?.name,
                "manager.id": requisitionItem?.requisition?.requestedBy?.id,
                "manager.name": requisitionItem?.requisition?.requestedBy?.name,
                uom: requisitionItem?.product?.unitOfMeasure,
                maxQuantity: requisitionItem?.quantity,
                replenishmentPeriod: requisitionItem?.requisition?.replenishmentPeriod,
                monthlyDemand: monthlyDemand,
        ]
    }
}
